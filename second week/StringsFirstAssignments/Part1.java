
/**
 * Finding a Gene and Web Links.
 * 
 * @author (Vladislav Fedorov) 
 * @version (1.0)
 */
public class Part1 {

    public String findSimpleGene(String dna) {
     
        String result = "";
        
        String upperDNA = dna.toUpperCase ();
        
        int startIndex = upperDNA.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int stopIndex = upperDNA.indexOf("TAA", startIndex+3);
        if (stopIndex == -1) {
            return "";
        }
        result = upperDNA.substring(startIndex, stopIndex+3);
        return result;
        
    };
    
    public void testFindGeneSimple() {
        
        String dna = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
       
        dna = "AATGCTAGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "ATGTAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
        dna = "atgtaa";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna);
        System.out.println("Gene is " + gene);
        
    };
        
}
