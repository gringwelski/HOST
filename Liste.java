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
		if(next == null)  // immer hinten anhängen
			next = new Liste(x);
		else
			next.einfuegen(x);
	}

	boolean loeschen(E x){
		if(self.equals(x)){  // Wenn die Liste nur ein Element enthält
			if(next != null){
				self=next.self;
				next=next.next;
			}else
				self = null;  // Liste ist leer, aber nicht null!
			return true;
		}
		if(next == null)   // Das gesuchte Element war nicht in der Liste
			return false;
		if(next.self.equals(x)){  // Im nächsten Knoten steht das gesuchte Elemente
			next = next.next;
			return true;
		}
		return next.loeschen(x);	
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
		l.loeschen(2);
		System.out.println(l.toString());
		
	}
	
}