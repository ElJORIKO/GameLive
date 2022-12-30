package ru.ElJORIKO.main.tools;

import ru.ElJORIKO.main.entrities.Point;
import ru.ElJORIKO.main.playingField.Field;

import javax.annotation.processing.FilerException;
import java.io.*;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Предназанчен для чтения field.map файла
 * Формат файла подразуменвает наличие блоков раздёлёнными пробелами <br>
 * Блок: 1:3<br>
 * Где 1 - x координата, 3 - y координата<br>
 */
public class Reader {
	private final String regexp = "^(\\s?[0-9]+:{1}[0-9]+?)+$";
	private Field field;
	public void readField(Field field, String filePath) throws FilerException {
		this.field = field;
		var map = new File(filePath);
		if (!map.exists())
			throw new FilerException("File " + filePath + " is not exist");
		try (BufferedReader bf = new BufferedReader(new FileReader(map))) {
			String line = bf.readLine();
			while (Objects.nonNull(line)) {
				if (line.equals("") | line.startsWith("#")){
					line = bf.readLine();
					continue;
				}
				if (Pattern.matches(regexp, line))
					parseLine(line);
				else
					throw new Exception("Error parse line: " + line + "\nby regexp: " + regexp);
				line = bf.readLine();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	private void parseLine(String line){
		var points = line.split(" ");
		for (var p : points){
			var coordinates = p.split(":");
			var point = new Point(Integer.parseInt(coordinates[1]), Integer.parseInt(coordinates[0]));
			field.setPoint(point, true);
		}
	}
}
