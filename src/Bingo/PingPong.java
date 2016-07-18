package Bingo;

public class PingPong implements Comparable<PingPong> {
	private String value;
	private int chance;
	
	public PingPong(String val){
		value = val;
		chance = 1;
	}
	public PingPong(String val, int chance){
		value = val;
		this.chance = chance;
	}
	public String getValue()
	{
		return value;
	}

	public void setName(String val)
	{
		this.value = val;
	}

	@Override
	public String toString()
	{
		return value;
	}
	
	public int compareTo(PingPong other){
		int compare = this.value.compareTo(other.value);
		if(this.value.charAt(0) == 'G' && (other.value.charAt(0) == 'I' || other.value.charAt(0) == 'N')){
			compare = 1;
		}
		else if(other.value.charAt(0) == 'G' && (this.value.charAt(0) == 'I' || this.value.charAt(0) == 'N'))
			compare = -1;
		return compare;
	}
}