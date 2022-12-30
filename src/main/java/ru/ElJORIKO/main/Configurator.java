package ru.ElJORIKO.main;

import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import ru.ElJORIKO.main.entrities.Arguments;

import java.util.concurrent.Callable;

@Command(name = "Game live", version = "0.0.1", description = "Game \"live\"", mixinStandardHelpOptions = true)
public class Configurator implements Callable<Integer> {
	@Option(names = {"-w", "-wight"}, description = "Wight field")
	public int wight = 10;
	@Option(names = {"-H", "-height"}, description = "Height field")
	public int height = 10;
	@Option(names = {"-a", "-alive"}, description = "Symbol alive cell")
	public char aliveCell = '*';
	@Option(names = {"-e", "-empty"}, description = "Symbol dead(empty) cell")
	public char emptyCell = ' ';
	@Option(names = {"-o", "-open"}, description = "Symbol open cell")
	public char openCell = ' ';
	@Option(names = {"-c", "-close"}, description = "Symbol close cell")
	public char closeCell = ' ';
	@Option(names = {"-t", "-time"}, description = "TimeOut refresh field")
	public long timeOut = 500L;
	@Option(names = {"-p", "-path"}, description = "Path to file configure field")
	public String conf = "field.map";
	@Option(names = {"-d", "-default"}, description = "Default run")
	public boolean def = false;
	@Option(names = {"-r", "-random"}, description = "Random place alive cell")
	public boolean rand = false;
	@Option(names = {"-h", "-help"}, usageHelp = true, description = "display this help message")
	boolean usageHelpRequested;

	@Override
	public Integer call() throws Exception {
		var arg = new Arguments();
		if (!def){
			arg.setWight(wight)
				.setHeight(height)
				.setAliveCell(aliveCell)
				.setEmptyCell(emptyCell)
				.setOpenCell(openCell)
				.setCloseCell(closeCell)
				.setTimeOut(timeOut)
				.setConf(conf)
				.setRandom(rand);
		}
		Main.runGame(arg);
		return null;
	}
}
