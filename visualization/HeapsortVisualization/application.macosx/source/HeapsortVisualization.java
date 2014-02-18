import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Arrays; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Random; 
import controlP5.*; 
import controlP5.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class HeapsortVisualization extends PApplet {







// Timer
int interval = 250;
int lastRecordedTime = 0;

private Comparable poles[];
private List<Comparable[]> steps;
private ControlP5 cp5;

boolean draw = false;

public void setup() {
  // Processing
  size(800, 500);

  // Instance vars
  this.cp5 = new ControlP5(this);
  this.poles = randomPoles(19);
  
  // Controls
  addComponents(cp5);
}

public void draw() {
  if (draw && millis() - lastRecordedTime > interval) {
    this.poles = nextStep();
    background(29);
    drawPoles(poles);
    lastRecordedTime = millis();
  }

  if (!draw) {
    background(29);
    drawPoles(poles);
  }
  
}

public void addComponents(ControlP5 cp5) {
  cp5.addBang("randomizePoles")
     .setPosition(15, 15)
     .setCaptionLabel("Randomize")
     .setSize(80, 50);
  cp5.addBang("hSort")
     .setPosition(115, 15)
     .setCaptionLabel("Heap sort")
     .setSize(80, 50);
  cp5.addKnob("interval")
     .setPosition(width - 80, 15)
     .setRadius(30)
     .setRange(100, 500)
     .setNumberOfTickMarks(8)
     .snapToTickMarks(true)
     .setValue(250);
}

public Comparable[] nextStep() {
  if (steps.size() > 1) {
    Comparable[] p = steps.remove(0);
    return p;
  }
  
  draw = false;
  return steps.get(0);
}

public void randomizePoles() {
  for (Comparable pole : poles) {
    Pole p = (Pole) pole;
    p.randomizeValue(19);
  }
}

public void hSort() {
  this.steps = new ArrayList<Comparable[]>();
  heapSort(poles);
  draw = true;
}

public Pole[] randomPoles(int n) {
  Pole p[] = new Pole[n];
  for (int i = 0; i < n; i++) {
    p[i] = new Pole(i, (new Random().nextInt(n) + 1), cp5);
  }

  return p;
}

public static void drawPoles(Comparable[] poles) {
  int i = 0;
  for (Comparable p : poles) {
    Pole pole = (Pole) p;
    if (pole != null) pole.draw(i++);
  }
}

/* ### Heap sort ### */
public void heapSort(Comparable a[]) {
  buildHeap(a);

  for (int i = 1; i < a.length; i++) {
    swap(a, 0, a.length - i);
    heapify(a, a.length - i, 0);
  }
}

public void buildHeap(Comparable a[]) {
  for (int i = parent(a.length - 1); -1 < i; i--) {
    heapify(a, a.length, i);
  }
}

public int parent(int child) {
  return (child / 2) + (child % 2) - 1;
}

public void heapify(Comparable a[], int len, int i) {
  if (i < 0) return;

  int l = (2 * i + 1);
  int r = l + 1;
  int greater;

  if (r < len) { // We have both children.
    greater = (a[l].compareTo(a[r]) < 0) ? r : l;

    // Compare if i needs to be swapped.
    if (a[i].compareTo(a[greater]) < 0) {
      swap(a, i, greater);
      heapify(a, len, greater);
    }
  }

  if (l == (len - 1) && a[i].compareTo(a[l]) < 0)
    swap(a, i, l);
}

public void swap(Comparable ary[], int i, int j) {
  Comparable temp = ary[i];
  ary[i] = ary[j];
  ary[j] = temp;
  Comparable c[] = new Comparable[ary.length];
  for (int k = 0; k < ary.length; k++) {
    c[k] = ary[k];
  }

  steps.add(c);
}




class Pole implements Comparable<Pole> {

  public int position;
  public int value;

  private ControlP5 cp5;
  private Textlabel valueLabel;

  Pole(int position, int value) {
    this.position = position;
    this.value = value;
  }

  Pole(int position, int value, ControlP5 cp5) {
    this.position = position;
    this.value = value;
    this.cp5 = cp5;
    this.valueLabel = cp5.addTextlabel("label" + position);
  }

  public void randomizeValue(int n) {
    this.value = new Random().nextInt(n) + 1;
  }

  public void draw(int position) {
    int w = 30;
    int h = value * 15 + 10;
    int xPos = position * (w + 10) + 20;
    int yPos = height - 25 - h;
    float c = map(value, 0, 19, 190, 50);
    colorMode(HSB, 19);
    fill(value, 13, 17);
    rect(xPos, yPos, 30, h);
    colorMode(RGB, 255);
    valueLabel.setText(String.format("%d", value))
      .setPosition(xPos + 8, height - 20);
  }

  @Override
    public int compareTo(Pole o) {
    return value - o.value;
  }

  @Override
    public String toString() {
    return String.format("new Pole(%d, %d, cp5)", position, value);
  }
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--hide-stop", "HeapsortVisualization" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
