package adventofcode.day3;

public class TobogganMapRow {

  private static char OPEN = '.';
  private static char TREE = '#';
  private int currentPosition = 0;
  private String row;

  public TobogganMapRow(String row) {
    this.row = row;
  }

  public void moveRight(int positions) {
    this.currentPosition += positions;

    if (this.currentPosition >= this.row.length()) {
      this.currentPosition = this.currentPosition - this.row.length();
    }
  }

  public void setPosition(int position) {
    this.currentPosition = position;
  }

  public int getPosition() {
    return this.currentPosition;
  }

  public boolean isOpen() {
    return this.row.charAt(this.currentPosition) == OPEN;
  }

  public boolean isTree() {
    return this.row.charAt(this.currentPosition) == TREE;
  }
}
