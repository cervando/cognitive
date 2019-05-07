package Test;

public class TestHash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("A".hashCode() & 0b111111111111);
		System.out.println("AA".hashCode() & 0b111111111111);
		System.out.println("AB".hashCode() & 0b111111111111);
		System.out.println("BA".hashCode() & 0b111111111111);

		System.out.println("Node1".hashCode() & 0b111111111111);
		System.out.println("Node2".hashCode() & 0b111111111111);
		
	}

}
