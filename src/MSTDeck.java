import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ryan Thorp on 02-Sep-16.
 */
public class MSTDeck {

    private ArrayList<MSTCard> cards;

    // List of all cards read from file or hard coded

    public MSTDeck() {
        cards = new ArrayList<MSTCard>();
        ArrayList<String> occurrence = new ArrayList<String>();

        //Play card creation
        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide01.jpg", "play", "Quartz", "SiO2", "tectosilicate", "hexagonal", occurrence, 7, 2.65, "poor/none", "high", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide02.jpg", "play", "Plagioclase", "Na Al Si3 O8 - Ca Al2 Si2 O8", "tectosilicate", "triclinic", occurrence, 6.5, 2.8, "1 perfect, 1 good", "very high", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide03.jpg", "play", "Orthoclase", "K Al Si3 O3", "tectosilicate", "monoclinic", occurrence, 6.5, 2.6, "1 perfect, 1 good", "high", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide04.jpg", "play", "Biotite", "K(Fe, Mg)3 Al Si3 O10 (OH)2", "phyllosilicate", "monoclinic", occurrence, 3, 3.3, "1 perfect", "moderate", "low"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide05.jpg", "play", "Muscovite", "K Al3 Si3 O10 (OH)2", "phyllosilicate", "monoclinic", occurrence, 3, 2.9, "1 perfect", "moderate", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide06.jpg", "play", "Hornblende", "Ca2 (Mg, Fe)4 Al2 Si7 O22 (OH)2", "inosilicate", "monoclinic", occurrence, 6, 3.5, "2 good", "moderate", "trivial"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide07.jpg", "play", "Actinolite", "Ca2 (Mg, Fe)5 Si8 O22 (OH)2", "inosilicate", "monoclinic", occurrence, 6, 3.5, "2 good", "low", "low"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide08.jpg", "play", "Glaucophane", "Na2 (Mg, Fe)3 Al2 Si8 O22 (OH)2", "inosilicate", "monoclinic", occurrence, 6, 3.2, "2 good", "low", "trivial"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("mantle");
        cards.add(new MSTCard("Slide09.jpg", "play", "Olivine", "(Mg, Fe)2 Si O4", "nesosilicate", "orthorhombic", occurrence, 7, 4.4, "2 poor", "high", "low"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("mantle");
        cards.add(new MSTCard("Slide10.jpg", "play", "Garnet", "(Fe, Mg, Ca, Mn)3 (Al, Fe)2 Si3 O12", "nesosilicate", "isometric", occurrence, 7.5, 4.3, "none", "moderate", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide11.jpg", "play", "Titanite", "Ca Ti Si O5", "nesosilicate", "monoclinic", occurrence, 5.5, 3.6, "3 good", "low", "low"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide12.jpg", "play", "Zircon", "Zr Si O4", "nesosilicate", "tetragonal", occurrence, 7.5, 4.7, "2 poor", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide13.jpg", "play", "Augite", "Ca (Mg, Fe) Si2 O6", "inosilicate", "monoclinic", occurrence, 6.5, 3.6, "2 good", "high", "trivial"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("mantle");
        cards.add(new MSTCard("Slide14.jpg", "play", "Orthopyroxene", "(Mg, Fe)2 Si2 O6", "inosilicate", "orthorhombic", occurrence, 6, 3.9, "2 good", "high", "trivial"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide15.jpg", "play", "Chlorite", "(Mg, Fe)5 Al2 Si3 O10 (OH)8", "phyllosilicate", "monoclinic", occurrence, 3, 3.3, "1 perfect", "moderate", "low"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("mantle");
        cards.add(new MSTCard("Slide16.jpg", "play", "Antigorite", "(Mg, Fe)3 Si2 O5 (OH)4", "phyllosilicate", "monoclinic", occurrence, 4, 2.6, "1 perfect", "low", "low"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide17.jpg", "play", "Talc", "Mg3 Si4 O10 (OH)2", "phyllosilicate", "monoclinic", occurrence, 1, 2.8, "1 perfect", "low", "moderate"));
        occurrence.clear();

        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide18.jpg", "play", "Kaolinite", "Al2 Si2 O5 (OH)4", "phyllosilicate", "triclinic", occurrence, 2.5, 2.7, "1 perfect", "moderate", "high"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide19.jpg", "play", "Andalusite", "Al2 Si O5", "nesosilicate", "orthorhombic", occurrence, 7, 3.15, "2 good", "low", "moderate"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide20.jpg", "play", "Kyanite", "Al2 Si O5", "nesosilicate", "triclinic", occurrence, 7, 3.7, "1 perfect, 1 good", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide21.jpg", "play", "Sillimanite", "Al2 Si O5", "nesosilicate", "orthorhombic", occurrence, 7.5, 3.25, "1 perfect, 1 good", "low", "low"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide22.jpg", "play", "Staurolite", "(Fe, Mg)2 Al9 Si4 O22 (OH)2", "nesosilicate", "monoclinic", occurrence, 7, 3.8, "1 good", "trace", "low"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide23.jpg", "play", "Epidote", "Ca2 (Al, Fe)3 Si3 O12 (OH)", "sorosilicate", "monoclinic", occurrence, 6.5, 3.5, "1 perfect", "moderate", "trivial"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide24.jpg", "play", "Tourmaline", "Na (Mg, Fe)3 Al6 B3 Si6 O27 (OH)4", "cyclosilicate", "hexagonal", occurrence, 7.5, 3.2, "2 poor", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide25.jpg", "play", "Topaz", "Al2 Si O4 (F, OH)2", "nesosilicate", "orthorhombic", occurrence, 8, 3.6, "1 perfect", "ultratrace", "low"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide26.jpg", "play", "Beryl", "Be3 Al2 Si6 O18", "cyclosilicate", "hexagonal", occurrence, 8, 2.9, "1 poor", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide27.jpg", "play", "Pyrite", "Fe S2", "sulfide", "isometric", occurrence, 6.5, 5, "2 poor", "low", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide28.jpg", "play", "Pyrrhotite", "Fe1-x S", "sulfide", "monoclinic", occurrence, 4.5, 4.6, "none", "low", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide29.jpg", "play", "Chalcopyrite", "Cu Fe S2", "sulfide", "tetragonal", occurrence, 4, 4.3, "2 poor", "low", "very high"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide30.jpg", "play", "Galena", "Pb S", "sulfide", "isometric", occurrence, 7.5, 7.6, "3 perfect", "trace", "high"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide31.jpg", "play", "Sphalerite", "(Zn, Fe) S", "sulfide", "isometric", occurrence, 4, 4.1, "6 perfect", "trace", "high"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide32.jpg", "play", "Molybdenite", "Mo S2", "sulfide", "hexagonal", occurrence, 1.5, 4.7, "1 perfect", "trace", "high"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide33.jpg", "play", "Gold", "Au", "native element", "isometric", occurrence, 3, 19.3, "none", "ultratrace", "I'm rich!"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide34.jpg", "play", "Diamond", "C", "native element", "isometric", occurrence, 10, 3.5, "4 perfect", "ultratrace", "I'm rich!"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide35.jpg", "play", "Graphite", "C", "native element", "hexagonal", occurrence, 2, 2.2, "1 perfect", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide36.jpg", "play", "Halite", "Na Cl", "halide", "isometric", occurrence, 2.5, 2.2, "3 perfect", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("metamorphic");
        cards.add(new MSTCard("Slide37.jpg", "play", "Fluorite", "Ca F2", "halide", "isometric", occurrence, 4, 3.2, "4 perfect", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide38.jpg", "play", "Gypsum", "Ca S O4 (H2 O)2", "sulfate", "monoclinic", occurrence, 2, 2.3, "1 perfect, 2 good", "trace", "high"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide39.jpg", "play", "Barite", "Ba S O4", "sulfate", "orthorhombic", occurrence, 3.5, 4.5, "2 perfect, 1 good", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide40.jpg", "play", "Apatite", "Ca5 (P O4)3 (OH, F, Cl)", "phosphate", "hexagonal", occurrence, 5, 3.2, "2 poor", "low", "high"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide41.jpg", "play", "Monazite", "(La, Ce, Nd) P O4", "phosphate", "monoclinic", occurrence, 5, 5.3, "1 good, 1 poor", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide42.jpg", "play", "Calcite", "Ca C O3", "carbonate", "hexagonal", occurrence, 3, 2.7, "3 perfect", "moderate", "high"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide43.jpg", "play", "Dolomite", "Ca Mg (C O3)2", "carbonate", "hexagonal", occurrence, 4, 2.9, "3 perfect", "low", "low"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide44.jpg", "play", "Magnesite", "Mg C O3", "carbonate", "hexagonal", occurrence, 4, 3.0, "3 perfect", "low", "moderate"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide45.jpg", "play", "Siderite", "Fe C O3", "carbonate", "hexagonal", occurrence, 4.5, 4, "3 perfect", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide46.jpg", "play", "Magnetite", "Fe3 O4", "oxide (spinel)", "isometric", occurrence, 6, 5.2, "none", "moderate", "very high"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide47.jpg", "play", "Hematite", "Fe2 O3", "oxide", "hexagonal", occurrence, 6, 5.3, "none", "trace", "high"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide48.jpg", "play", "Chromite", "(Fe, Mg) Cr2 O4", "oxide (spinel)", "isometric", occurrence, 5.5, 5.1, "none", "low", "high"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide49.jpg", "play", "Ilmenite", "Ti Fe O3", "oxide", "hexagonal", occurrence, 6, 4.8, "none", "low", "moderate"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide50.jpg", "play", "Rutile", "Ti O2", "oxide", "tetragonal", occurrence, 6.5, 4.3, "2 good", "low", "high"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide51.jpg", "play", "Corundum", "Al2 O3", "oxide", "hexagonal", occurrence, 9, 4.0, "none", "trace", "moderate"));
        occurrence.clear();

        occurrence.add("igneous");
        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide52.jpg", "play", "Cassiterite", "Sn O2", "oxide", "tetragonal", occurrence, 7, 7.1, "1 good, 1 poor", "trace", "high"));
        occurrence.clear();

        occurrence.add("metamorphic");
        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide53.jpg", "play", "Gibbsite", "Al (O H)3", "hydroxide", "monoclinic", occurrence, 3.5, 2.4, "1 perfect", "low", "high"));
        occurrence.clear();

        occurrence.add("sedimentary");
        cards.add(new MSTCard("Slide54.jpg", "play", "Goethite", "Fe O (OH)", "hydroxide", "orthorhombic", occurrence, 5.5, 4.3, "1 perfect, 1 good", "moderate", "moderate"));
        occurrence.clear();

        //Trump card creation
        cards.add(new MSTCard("Slide55.jpg", "trump", "The Miner", "Economic Value", "", "", occurrence, 0, 0, "", "", ""));

        cards.add(new MSTCard("Slide56.jpg", "trump", "The Petrologist", "Crustal Abundance", "", "", occurrence, 0, 0, "", "", ""));

        cards.add(new MSTCard("Slide58.jpg", "trump", "The Mineralogist", "Cleavage", "", "", occurrence, 0, 0, "", "", ""));

        cards.add(new MSTCard("Slide59.jpg", "trump", "The Geophysicist", "Specific Gravity", "", "", occurrence, 0, 0, "", "", ""));

        cards.add(new MSTCard("Slide60.jpg", "trump", "The Geologist", "your choice", "", "", occurrence, 0, 0, "", "", ""));
    }


    public ArrayList<MSTCard> dealCards(int numCardsToDeal) {
        ArrayList<MSTCard> res = new ArrayList<MSTCard>();
        for (int i = 0; i < numCardsToDeal; i++) {
            int idx = new Random().nextInt(cards.size());
            MSTCard card = cards.remove(idx);
            res.add(card);
//            System.out.println(card);
        }
        return res;
    }
}
