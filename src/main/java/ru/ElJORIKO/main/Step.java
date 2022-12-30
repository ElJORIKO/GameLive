package ru.ElJORIKO.main;

import ru.ElJORIKO.main.entrities.Point;
import ru.ElJORIKO.main.playingField.Field;

import java.util.Arrays;

public class Step {
	private Field field;
	private Field oldField;
	private Boolean gameOver = false;

	public Step(Field field) {
		this.field = new Field(field.getSize());
		this.oldField = field;
	}

	public boolean gameContinues(){
		return !gameOver;
	}

	public void makeStep(){
		for (int i = 0; i < oldField.getSize().getWight(); i++) {
			for (int j = 0; j < oldField.getSize().getHeight(); j++) {
				var point = new Point(i, j);

				if (oldField.getPoint(point)) {
					field.setPoint(point, totalPointsAround(point) == 2 | totalPointsAround(point) == 3);
				} else {
					if (totalPointsAround(point) == 3){
						field.setPoint(point, true);
					}
				}
			}
		}
		gameOver = isGameOver();
		if (Arrays.deepEquals(oldField.getField(), field.getField())) gameOver = true;
		oldField = field;
		field = new Field(field.getSize());
	}

	public Field getField() {
		return oldField;
	}

	private boolean isGameOver(){
		boolean over = true;
		for (var i = 0; i < field.getSize().getHeight(); i++){
			for (int j = 0; j < field.getSize().getWight(); j++) {
				if (field.getPoint(new Point(i,j)))
					over = false;
			}
		}
		return over;
	}

	private int totalPointsAround(Point point){
		int count = 0;
		for (var i = -1; i <= 1; i++){
			for (var j = -1; j <= 1; j++){
				if (i == 0 & j == 0) {
					continue;
				}

				if (oldField.getPoint(
						new Point( point.getX() + i, point.getY() + j )
					) )
					count++;
			}
		}
		return count;
	}
}
