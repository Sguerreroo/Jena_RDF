package ejercicio1_rdf_jena;

public class Language {
    private final String id, label;

    public Language(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Language{" + "id=" + id + ", label=" + label + '}';
    }
    
}
