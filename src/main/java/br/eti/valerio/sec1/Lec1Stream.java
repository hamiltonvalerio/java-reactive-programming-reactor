package br.eti.valerio.sec1;

import java.util.stream.Stream;

public class Lec1Stream {

	public static void main(String[] args) {
		Stream<Integer> stream01 = Stream.of(1).map(i -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return i * 2;
		});
		
		stream01.forEach(System.out::println);
	}
}
