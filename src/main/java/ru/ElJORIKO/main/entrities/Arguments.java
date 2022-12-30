package ru.ElJORIKO.main.entrities;

public class Arguments {
	private boolean RANDOM_PLACE = false;
	private int WIGHT = 10;
	private int HEIGHT = 10;
	private char ALIVE_CELL = '*';
	private char EMPTY_CELL = ' ';
	private char CLOSE_CELL = '}';
	private char OPEN_CELL = '{';
	private long TIME_OUT_STEP = 500L;
	private String CONF_FILE = "field.map";
	public Arguments(){}
	public Arguments setRandom(boolean rand){
		this.RANDOM_PLACE = rand;
		return this;
	}
	public Arguments setWight(int wight){
		this.WIGHT = wight;
		return this;
	}
	public Arguments setHeight(int height){
		this.HEIGHT = height;
		return this;
	}
	public Arguments setAliveCell(char aliveCell){
		this.ALIVE_CELL = aliveCell;
		return this;
	}
	public Arguments setEmptyCell(char emptyCell){
		this.EMPTY_CELL = emptyCell;
		return this;
	}
	public Arguments setCloseCell(char closeCell){
		this.CLOSE_CELL = closeCell;
		return this;
	}
	public Arguments setOpenCell(char openCell){
		this.OPEN_CELL = openCell;
		return this;
	}
	public Arguments setTimeOut(long timeOut){
		this.TIME_OUT_STEP = timeOut;
		return this;
	}
	public Arguments setConf(String conf) {
		this.CONF_FILE = conf;
		return this;
	}
	public String getConfFile() {
		return CONF_FILE;
	}
	public long getTimeOutStep() {
		return TIME_OUT_STEP;
	}
	public char getOpenCell() {
		return OPEN_CELL;
	}
	public char getCloseCell() {
		return CLOSE_CELL;
	}
	public char getEmptyCell() {
		return EMPTY_CELL;
	}
	public char getAliveCell() {
		return ALIVE_CELL;
	}
	public int getHeight() {
		return HEIGHT;
	}
	public int getWight() {
		return WIGHT;
	}
	public boolean getRandom() {
		return RANDOM_PLACE;
	}
}
