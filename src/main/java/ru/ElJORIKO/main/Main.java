package ru.ElJORIKO.main;

import ru.ElJORIKO.main.entrities.Arguments;
import ru.ElJORIKO.main.entrities.FieldSize;
import ru.ElJORIKO.main.playingField.Field;
import ru.ElJORIKO.main.tools.Reader;

import javax.annotation.processing.FilerException;

/**
 * Место действия игры — размеченная на клетки плоскость, которая может быть безграничной, ограниченной или замкнутой.
 * Каждая клетка на этой поверхности имеет восемь соседей, окружающих её, и может находиться в двух состояниях: быть «живой» (заполненной) или «мёртвой» (пустой).
 * Распределение живых клеток в начале игры называется первым поколением. Каждое следующее поколение рассчитывается на основе предыдущего по таким правилам:
 * в пустой (мёртвой) клетке, с которой соседствуют три живые клетки, зарождается жизнь;
 * если у живой клетки есть две или три живые соседки, то эта клетка продолжает жить; в противном случае (если живых соседей меньше двух или больше трёх) клетка умирает («от одиночества» или «от перенаселённости»).
 * Игра прекращается, если на поле не останется ни одной «живой» клетки;
 */
public class Main {
	public static char symbol = '#';
	public static char open = '{';
	public static char close = '}';
	public static char empty = ' ';
	public static void main(String[] args) throws InterruptedException {
		new picocli.CommandLine(new Configurator()).execute(args);
	}

	public static void runGame(Arguments args) throws InterruptedException, FilerException {
		empty  = args.getEmptyCell();
		close  = args.getCloseCell();
		open   = args.getOpenCell();
		symbol = args.getAliveCell();
		var field = new Field(new FieldSize(args.getWight(), args.getHeight()));
		if (args.getRandom())
			field.putRandomPoints();
		else
			new Reader().readField(field, args.getConfFile());

		var engine = new Step(field);
		field.printFiled();

		while (engine.gameContinues()){
			engine.makeStep();
			Thread.sleep(args.getTimeOutStep());
			engine.getField().printFiled();
		}
		System.out.println();
	}
}
