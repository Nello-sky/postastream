package it.prova.postastream.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MockData {

	public static final List<PostaDiPaese> POSTE_LIST = new ArrayList<>();

	static {
		PostaDiPaese primaPosta = new PostaDiPaese(1L, "primaPosta", "Via Roma 2", LocalDate.of(2022, 05, 12), 50);
		Destinatario destPrimaPosta1 = new Destinatario(50L, "luca", "rossi", 45, "Via Sale 5", true, primaPosta);
		primaPosta.getDestinatari().add(destPrimaPosta1);
		Destinatario destPrimaPosta2 = new Destinatario(51L, "mario", "sole", 47, "Via Sasso 15", false, primaPosta);
		primaPosta.getDestinatari().add(destPrimaPosta2);

		PostaDiPaese secondaPosta = new PostaDiPaese(2L, "secondaPostaCentrale", "Via Minetti 3", LocalDate.of(2010, 04, 11), 10);
		Destinatario destPrimaPosta3 = new Destinatario(60L, "fioro", "sal", 21, "Via Mare 5", false, secondaPosta);
		secondaPosta.getDestinatari().add(destPrimaPosta3);
		Destinatario destPrimaPosta4 = new Destinatario(61L, "maria", "grati", 49, "Via Erba 15", true, secondaPosta);
		secondaPosta.getDestinatari().add(destPrimaPosta4);
		
		PostaDiPaese terzaPosta = new PostaDiPaese(3L, "terzaPosta", "Via Milano 3", LocalDate.of(2015, 04, 11), 9);
		Destinatario destPrimaPosta5 = new Destinatario(70L, "marco", "altieri", 55, "Via orso 5", true, terzaPosta);
		terzaPosta.getDestinatari().add(destPrimaPosta5);
		Destinatario destPrimaPosta6 = new Destinatario(71L, "lucio", "corsi", 49, "Via buoni 77", false, terzaPosta);
		terzaPosta.getDestinatari().add(destPrimaPosta6);
		
		PostaDiPaese quartaPosta = new PostaDiPaese(4L, "quartaPostaCentrale", "Via orto 13", LocalDate.of(2011, 04, 11), 60);
		Destinatario destPrimaPosta7 = new Destinatario(80L, "salvo", "olo", 27, "Via ciro 8", true, quartaPosta);
		quartaPosta.getDestinatari().add(destPrimaPosta7);
		
		PostaDiPaese quintaPosta = new PostaDiPaese(5L, "quintaPostaCentrale", "Via gioco 13", LocalDate.of(2030, 04, 11), 11);
		Destinatario destPrimaPosta8 = new Destinatario(90L, "gino", "pino", 99, "Via sacco 18", true, quintaPosta);
		quintaPosta.getDestinatari().add(destPrimaPosta8);
		
		POSTE_LIST.add(primaPosta);
		POSTE_LIST.add(secondaPosta);
		POSTE_LIST.add(terzaPosta);
		POSTE_LIST.add(quartaPosta);
		POSTE_LIST.add(quintaPosta);
	}
	
}
