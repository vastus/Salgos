import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import controlP5.*;

// Timer
int interval = 250;
int lastRecordedTime = 0;

private Comparable poles[];
private List<Comparable[]> steps;
private ControlP5 cp5;

boolean draw = false;

void setup() {
  // Processing
  size(800, 500);

  // Instance vars
  this.cp5 = new ControlP5(this);
  this.poles = randomPoles(19);
  
  // Controls
  addComponents(cp5);
}

void draw() {
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

void addComponents(ControlP5 cp5) {
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

Comparable[] nextStep() {
  if (steps.size() > 1) {
    Comparable[] p = steps.remove(0);
    return p;
  }
  
  draw = false;
  return steps.get(0);
}

void randomizePoles() {
  for (Comparable pole : poles) {
    Pole p = (Pole) pole;
    p.randomizeValue(19);
  }
}

void hSort() {
  this.steps = new ArrayList<Comparable[]>();
  heapSort(poles);
  draw = true;
}

Pole[] randomPoles(int n) {
  Pole p[] = new Pole[n];
  for (int i = 0; i < n; i++) {
    p[i] = new Pole(i, (new Random().nextInt(n) + 1), cp5);
  }

  return p;
}

static void drawPoles(Comparable[] poles) {
  int i = 0;
  for (Comparable p : poles) {
    Pole pole = (Pole) p;
    if (pole != null) pole.draw(i++);
  }
}

/* ### Heap sort ### */
void heapSort(Comparable a[]) {
  buildHeap(a);

  for (int i = 1; i < a.length; i++) {
    swap(a, 0, a.length - i);
    heapify(a, a.length - i, 0);
  }
}

void buildHeap(Comparable a[]) {
  for (int i = parent(a.length - 1); -1 < i; i--) {
    heapify(a, a.length, i);
  }
}

int parent(int child) {
  return (child / 2) + (child % 2) - 1;
}

void heapify(Comparable a[], int len, int i) {
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

void swap(Comparable ary[], int i, int j) {
  Comparable temp = ary[i];
  ary[i] = ary[j];
  ary[j] = temp;
  Comparable c[] = new Comparable[ary.length];
  for (int k = 0; k < ary.length; k++) {
    c[k] = ary[k];
  }

  steps.add(c);
}


