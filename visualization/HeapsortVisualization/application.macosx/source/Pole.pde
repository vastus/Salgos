import controlP5.*;

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

  void randomizeValue(int n) {
    this.value = new Random().nextInt(n) + 1;
  }

  void draw(int position) {
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

