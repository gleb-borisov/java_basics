import java.util.Comparator;

class DomainNameComparator implements Comparator<Domain> {

    public int compare (Domain domain1, Domain domain2) {
        return domain1.getName().compareTo(domain2.getName());
    }
}

class DomainSldComparator implements Comparator<Domain> {

    public int compare (Domain domain1, Domain domain2) {
        return domain1.getSld().compareTo(domain2.getSld());
    }
}

class DomainTldComparator implements Comparator<Domain> {

    public int compare (Domain domain1, Domain domain2) {
        return domain1.getTld().compareTo(domain2.getTld());
    }
}

