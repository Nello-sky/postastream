package it.prova.postastream.test;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import it.prova.postastream.model.Destinatario;
import it.prova.postastream.model.MockData;
import it.prova.postastream.model.PostaDiPaese;

public class PosteDestinatarioTest {

	public static void main(String[] args) {
		List<PostaDiPaese> postaDestinatariList = MockData.POSTE_LIST;
		// System.out.println(postaDestinatariList.get(1).getIndirizzoSede());

/////////tutte le poste il cui indirizzo contenga “(MI)”///////////////////////////////////////////////////////////////////
		String subStringIndirizziPoste = "Mi"; // il controllo è caseSensitive
		System.out.println("- - - tutte le poste il cui indirizzo contiente:" + " " + subStringIndirizziPoste);
		//
//		postaDestinatariList.forEach(item -> {
//			if (item.getIndirizzoSede().contains(subStringIndirizziPoste)) {
//				System.out.println(item.getId() + " " + item.getDenominazione());
//			}
//		});
		//
		List<PostaDiPaese> PosteConIndirizzoContenenti = postaDestinatariList.stream()
				.filter(postaItem -> postaItem.getIndirizzoSede().contains(subStringIndirizziPoste))
				.collect(Collectors.toList());
		// print
		PosteConIndirizzoContenenti.forEach(postaItem -> System.out
				.println(postaItem.getId() + " " + postaItem.getDenominazione() + " " + postaItem.getIndirizzoSede()));

		System.out.println("");
/////////tutte le poste che sono state aperte dopo il primo marzo 2019///////////////////////////////////////////////////////////////////
		LocalDate startDate = LocalDate.of(2019, 03, 1);
		System.out.println("- - - tutte le poste aperte dopo il:" + " " + startDate);

		List<PostaDiPaese> PosteAperteDopoData = postaDestinatariList.stream()
				.filter(postaItem -> postaItem.getDataApertura().isAfter(startDate)).collect(Collectors.toList());
		// print
		PosteAperteDopoData.forEach(postaItem -> System.out
				.println(postaItem.getId() + " " + postaItem.getDenominazione() + " " + postaItem.getIndirizzoSede()));

		System.out.println("");

/////////la lista di indirizzi delle poste il cui numero dipendenti sia superiore a 20///////////////////////////////////////////////////////////////////

		int numeroDipendentiTest = 20;

		System.out
				.println("- - - tutte le poste aperte con numero dipendenti maggiore di:" + " " + numeroDipendentiTest);

		System.out.println("a)");

		List<PostaDiPaese> PosteConDipendentiMaggioriDi = postaDestinatariList.stream()
				.filter(postaItem -> postaItem.getNumeroDipendenti() > numeroDipendentiTest)
				.collect(Collectors.toList());
		// print
		PosteConDipendentiMaggioriDi.forEach(postaItem -> System.out
				.println(postaItem.getId() + " " + postaItem.getDenominazione() + " " + postaItem.getIndirizzoSede()));

		List<String> indirizziPosteConDipendentiMaggioriDi = PosteConDipendentiMaggioriDi.stream().map(PostItem -> {
			String testoStar = PostItem.getIndirizzoSede();
			return testoStar;
		}).collect(Collectors.toList());
		// stampo
		indirizziPosteConDipendentiMaggioriDi.forEach(s -> System.out.println(s));

		System.out.println("b) compatta"); // c'è una versione compatta?

		List<String> listaAddressNuovaPerDipendenti = postaDestinatariList.stream()
				.filter(posta2Item -> posta2Item.getNumeroDipendenti() > numeroDipendentiTest)
				.map(posta2Item -> posta2Item.getIndirizzoSede())
				.peek(ppp -> System.out.println("giusto per capire cosa passa..." + ppp)).collect(Collectors.toList());
		listaAddressNuovaPerDipendenti.forEach(l -> System.out.println(l));

		System.out.println("");
/////////la lista di indirizzi di destinatari di poste con almeno 10 dipendenti///////////////////////////////////////////////////////////////////
		int numeroDipendentiTest2 = 10;
		System.out.println(
				"- - - lista di indirizzi delle poste aperte con almeno " + numeroDipendentiTest2 + " dipendenti");

		System.out.println("a) lungo");
		List<PostaDiPaese> PosteWithWorkersGreaterThan = postaDestinatariList.stream()
				.filter(postaItem -> postaItem.getNumeroDipendenti() >= numeroDipendentiTest2)
				.collect(Collectors.toList());

		List<Destinatario> listaDestinatariPosteConDipendentiMaggioriDi = PosteWithWorkersGreaterThan.stream()
				.flatMap(x -> x.getDestinatari().stream()).collect(Collectors.toList());

		List<String> listaIndirizziDestinatariPosteConDipendentiMaggioriDi = listaDestinatariPosteConDipendentiMaggioriDi
				.stream().map(DestinatarioItem -> {
					String addressStar = DestinatarioItem.getIndirizzo();
					return addressStar;
				}).collect(Collectors.toList());
		// stampo
		listaIndirizziDestinatariPosteConDipendentiMaggioriDi.forEach(s -> System.out.println(s));

		System.out.println("b) compatto");

		List<String> listaAddressDestinatariPosteConDipendentiMaggioriDi = postaDestinatariList.stream()
				.filter(postaItem -> postaItem.getNumeroDipendenti() >= numeroDipendentiTest2)
				.flatMap(x -> x.getDestinatari().stream()).map(destItem -> destItem.getIndirizzo())
				.peek(aaa -> System.out.println("giusto per capire cosa passa..." + aaa)).collect(Collectors.toList());
		listaAddressDestinatariPosteConDipendentiMaggioriDi.forEach(l -> System.out.println(l));

		System.out.println("");

/////////lista di destinatari possessori di conto corrente e appartenenti a poste con numero dipendenti compreso tra 50 e 100///////////////////////////////////////////////////////////////////
		int numeroDipendentiMax = 100;
		int numeroDipendentiMin = 50;
		System.out.println(
				"- - - lista di indirizzi dei destinatari con conto corrente nelle poste con dipendenti compresi tra "
						+ numeroDipendentiMin + " e " + numeroDipendentiMax);

		List<Destinatario> listDestinatariConContoInPosteConCheckDipendenti = postaDestinatariList.stream()
				.filter(postaItem -> (postaItem.getNumeroDipendenti() >= numeroDipendentiMin
						&& postaItem.getNumeroDipendenti() <= numeroDipendentiMax))
				.flatMap(x -> x.getDestinatari().stream().filter(destToken -> destToken.getPossessoreDiContoCorrente() == true ))
				.peek(aaa -> System.out.println("giusto per capire cosa passa..." + aaa)).collect(Collectors.toList());

		listDestinatariConContoInPosteConCheckDipendenti.forEach(destItem -> System.out.println(
				destItem.getId() + " " + destItem.getNome() + " " + destItem.getCognome() + " " + destItem.getEta()
						+ " " + destItem.getIndirizzo() + " " + destItem.getPossessoreDiContoCorrente()));
	}

}
