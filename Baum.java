class Baum<E extends Comparable>{
	private E self;
	private Baum<E> links;
	private Baum<E> rechts;
	
	Baum(E x){ self = x;}

	boolean enthaelt(E x){
		if (self.compareTo(x) >  0){ // self < x
			if(links == null) return false;
			return links.enthaelt(x);
		}
		if (self.compareTo(x) < 0){ // self > x
			if(rechts == null) return false;
			return rechts.enthaelt(x);
		}
		return self.equals(x);
	}
	void einfuegen(E x){
		if (self.compareTo(x) >=0){
			if(links == null)
				links = new Baum<E>(x);
			else
				links.einfuegen(x);
		}else{
			if(rechts == null)
				rechts = new Baum<E>(x);
			else
				rechts.einfuegen(x);
		}
		
	}
	
	public String toString(){
		String l="";
		String r="";
		if (links != null)
			 l=links.toString();
		 if(rechts != null)
		 	 r=rechts.toString();
		return l+","+self.toString()+","+r;	
	}
	
	public static void main(String[] a){
		Baum<Integer> b = new Baum<>(2);
		b.einfuegen(1);
		b.einfuegen(3);
		
		System.out.println(b);
		
	}
}