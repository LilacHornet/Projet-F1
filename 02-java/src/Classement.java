/* =========================================================================
   MAILLON 2 — JAVA : le moteur de calcul
   Complétez les quatre méthodes. Les classes Ligne, Resultat et Chargeur
   sont fournies : ne les modifiez pas.
       javac -encoding UTF-8 -d out src/*.java
       java -Dstdout.encoding=UTF-8 -cp out Tests     (les tests)
       java -Dstdout.encoding=UTF-8 -cp out Main      (la production)
   ========================================================================= */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classement {

    /** Barème officiel des dix premiers. FOURNI — NE PAS MODIFIER. */
    public static final int[] BAREME = { 25, 18, 15, 12, 10, 8, 6, 4, 2, 1 };

    // 1. pointsPourPosition(position) : points marqués pour cette position.
    // 1 -> 25, 2 -> 18, ..., 10 -> 1. Au-delà de la 10e place : 0.
    // Un abandon vaut la position 0, donc 0 point.
    public static int pointsPourPosition(int position) {
        switch (position) {
            case 1:
                return 25;
            case 2:
                return 18;
            case 3:
                return 15;
            case 4:
                return 12;
            case 5:
                return 10;
            case 6:
                return 8;
            case 7:
                return 6;
            case 8:
                return 4;
            case 9:
                return 2;
            case 10:
                return 1;
            default:
                return 0;
        }
        
    }

    // 2. classementPilotes(lignes) : un Resultat par pilote, avec ses points,
    // ses victoires (position 1) et ses 2e places, trié par :
    // points décroissants, puis victoires, puis 2e places, puis nom (A→Z).
    public static List<Resultat> classementPilotes(List<Ligne> lignes) {
        Map<String, Resultat> resultats = new HashMap<>();

        for (Ligne ligne : lignes) {
            Resultat resultat = resultats.computeIfAbsent(
                    ligne.pilote(),
                    nom -> new Resultat(nom, ligne.ecurie()));

            resultat.points += pointsPourPosition(ligne.position());

            if (ligne.position() == 1) {
                resultat.victoires++;
            } else if (ligne.position() == 2) {
                resultat.deuxiemes++;
            }
        }

        List<Resultat> classement = new ArrayList<>(resultats.values());

        classement.sort(
                Comparator.comparingInt((Resultat r) -> r.points).reversed()
                        .thenComparingInt(r -> r.victoires).reversed()
                        .thenComparingInt(r -> r.deuxiemes).reversed()
                        .thenComparing(r -> r.nom));

        return classement;
    }

    // 3. classementEcuries(pilotes) : additionne les points, victoires et
    // 2e places des pilotes de chaque écurie. Même ordre de tri.
    public static List<Resultat> classementEcuries(List<Resultat> pilotes) {
        Map<String, Resultat> resultats = new HashMap<>();

        for (Resultat pilote : pilotes) {
            Resultat resultat = resultats.computeIfAbsent(
                    pilote.ecurie,
                    nom -> new Resultat(nom, ""));

            resultat.points += pilote.points;
            resultat.victoires += pilote.victoires;
            resultat.deuxiemes += pilote.deuxiemes;
        }

        List<Resultat> classement = new ArrayList<>(resultats.values());

        classement.sort(
                Comparator.comparingInt((Resultat r) -> r.points).reversed()
                        .thenComparingInt(r -> r.victoires).reversed()
                        .thenComparingInt(r -> r.deuxiemes).reversed()
                        .thenComparing(r -> r.nom));

        return classement;

    }

    // 4. positionMoyenne(lignes, pilote) : moyenne des positions de ce pilote,
    // ABANDONS EXCLUS, arrondie à 2 décimales. 0 s'il n'a jamais terminé.
    // Ex. positions 1, 2 et un abandon -> 1.5
    public static double positionMoyenne(List<Ligne> lignes, String pilote) {
        int sommePositions = 0;
        int nbCourses = 0;
        for (int i = 0; i < lignes.size(); i++) {
            if ((lignes.get(i).pilote().equals(pilote))  && (lignes.get(i).position() != 0)) {
                sommePositions += lignes.get(i).position();
                nbCourses++;
            }
            
        }
        if(nbCourses == 0){
            return 0;
        }
        else{
            return (Math.round(((float)sommePositions / (float)nbCourses) * 100) / 100.0);
        }
    }
}
