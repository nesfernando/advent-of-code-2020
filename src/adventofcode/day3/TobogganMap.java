package adventofcode.day3;

import java.util.List;

public class TobogganMap {

  private List<TobogganMapRow> rows;
  private int currentRow = 0;

  public TobogganMap(List<TobogganMapRow> rows) {
    this.rows = rows;
  }

  public boolean canMoveDown() {
    return this.currentRow < this.rows.size() - 1;
  }

  public void moveDown() {
    this.moveDown(1);
  }

  public void moveDown(int positions) {
    int rowPosition = this.rows.get(this.currentRow).getPosition();
    this.currentRow += positions;
    this.rows.get(this.currentRow).setPosition(rowPosition);
  }

  public void moveRight(int positions) {
    this.rows.get(this.currentRow).moveRight(positions);
  }

  public boolean isOpen() {
    return this.rows.get(this.currentRow).isOpen();
  }

  public boolean isTree() {
    return this.rows.get(this.currentRow).isTree();
  }
}
