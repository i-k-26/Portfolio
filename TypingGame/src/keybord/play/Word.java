package keybord.play;

public class Word {

	private String spell;
	private String sense;
	private String yomi;
	private int wordcount;

	public Word(String spell, String sense,int wordcount) {

		this.spell = spell;
		this.sense = sense;
		this.wordcount = wordcount;

	}

	public Word(String spell, String yomi) {

		this.spell = spell;
		this.yomi = yomi;
	}


	public String getSpell() {
		return spell;
	}

	public void setSpell(String spell) {
		this.spell = spell;
	}

	public String getSense() {
		return sense;
	}

	public void setSense(String sense) {
		this.sense = sense;
	}

	public String getYomi() {
		return yomi;
	}

	public void setYomi(String yomi) {
		this.yomi = yomi;
	}

	public int getWordcount() {
		return this.wordcount;
	}

}


