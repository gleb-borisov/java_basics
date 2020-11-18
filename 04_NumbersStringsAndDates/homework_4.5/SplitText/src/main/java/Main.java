public class Main {

  public static void main(String[] args) {
    String text = "The Chinese -+== government has condemned the mass resignation of most of Hong Kong's opposition from parliament as an open challenge to its authority. Nearly all pro-democracy lawmakers have resigned in protest after four of their colleagues were deemed threats to national security and dismissed. Many see Hong Kong's limited democracy as now being in its death throes. The UK government has accused China of breaching its commitments to protect Hong Kong's autonomy. The former British colony became part of China in 1997 but was promised it could keep some unique freedoms for 50 years. UK Foreign Secretary Dominic Raab said of Wednesday's move to remove the four lawmakers: \"Beijing's imposition of new rules to disqualify elected legislators in Hong Kong constitutes a clear breach of the legally binding Sino-British Joint Declaration. China has once again broken its promises and undermined Hong Kong's high degree of autonomy. The US also condemned what had happened, saying it was a move towards one-party dictatorship, while the EU called for an immediate reversal of the decision. Hong Kong's government and authorities in Beijing have defended the disqualifications as lawful. They were based on new rules from China saying elected legislators should be disqualified if they support Hong Kong's independence, refuse to acknowledge China's sovereignty, ask foreign forces to interfere in the city's affairs, or in other ways threaten national security. Can Hong Kong's democracy fight survive the walkout? The mainland authorities in Beijing have taken increasingly repressive measures in Hong Kong since mass protests rocked the city last year. Activists have fled and political parties have disbanded following Beijing's passing of a new National Security Law in June, which criminalises vague acts including subversion. The imposition of the law was also deemed by Britain to have breached the joint declaration, which was signed in 1984.";

    System.out.println(splitTextInToWords(text));
  }

  public static String splitTextInToWords(String text) {
    String[] wordArray = text.split("[^a-zA-Z]\\p{Punct}*\\s*");
    for (String word : wordArray) {
      System.out.println(word);
    }
    return "";
  }
}