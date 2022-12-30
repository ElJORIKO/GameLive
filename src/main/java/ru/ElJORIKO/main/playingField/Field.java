package ru.ElJORIKO.main.playingField;

import ru.ElJORIKO.main.entrities.FieldSize;
import ru.ElJORIKO.main.entrities.Point;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static ru.ElJORIKO.main.Main.*;

public class Field {
	private final char[][] field;
	private final FieldSize size;

	public Field(FieldSize size) {
		this.size = size;
		this.field = new char[size.getWight()][size.getHeight()];
		fillField();
	}

	private void fillField(){
		for (char[] chars : field) {
			Arrays.fill(chars, empty);
		}
	}

	public char[][] getField() {
		return field;
	}

	public void printFiled(){
		System.out.print("\u001b[2J" + "\u001b[H");
		System.out.println();
		for (var wight : field){
			for (var height : wight){
				System.out.print(String.valueOf(open) + height + close + "");
			}
			System.out.println();
		}
	}

	public FieldSize getSize(){
		return size;
	}

	public boolean getPoint(Point point){
		if (point.getX() < 0)
			return false;
		if (point.getY() < 0)
			return false;

		try {
			return field[point.getX()][point.getY()] == symbol;
		} catch (ArrayIndexOutOfBoundsException e){
			return false;
		}
	}

	public void setPoint(Point point, boolean state){
		field[point.getX()][point.getY()] = state ? symbol : empty;
	}

	public void putRandomPoints() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = ThreadLocalRandom.current().nextInt(0, 1000) < 200 ? symbol : empty;
			}
		}
	}
}
