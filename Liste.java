class Liste<E>{
	private E self;
	private Liste<E> next;
	Liste(E e){ self = e;}
	boolean enthaelt(E x){
		if(self.equals(x)) return true; 
		if(next == null) return false;
		return next.enthaelt(x);
	}
	void einfuegen(E x){
		if(next == null)
			next = new Liste(x);
		else
			next.einfuegen(x);
	}
	
	public String toString(){
		if (next == null)
			return self.toString();
		return self.toString() +"," +next.toString();	
		
	}
	
	public static void main(String[] a){
		Liste<Integer> l = new Liste<>(1);
		l.einfuegen(2);
		l.einfuegen(3);
		System.out.println(l.toString()+l.enthaelt(2));
		
	}
	
}