package ReconnaissanceVocale;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Main {
    public static void main(String[] args) {
        try {
            Configuration configuration = new Configuration();

            configuration.setSampleRate(8000);
            configuration.setAcousticModelPath("file:resources/fr");
            configuration.setDictionaryPath("file:resources/fr/fr.dict");
            configuration.setLanguageModelPath("file:resources/fr/language-model.lm.bin");
            configuration.setSampleRate(16000);


            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
            recognizer.startRecognition(true);

            System.out.println("Parlez en français dans le micro...");

            SpeechResult result;
            while ((result = recognizer.getResult()) != null) {
                String hypothesis = result.getHypothesis();
                System.out.println("Texte reconnu : " + hypothesis);
            }

            recognizer.stopRecognition();
        } catch (Exception e) {
            System.err.println("Erreur lors de la reconnaissance vocale : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
