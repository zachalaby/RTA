package services;
//import view.DrawPanel;

import javafx.application.Application;
import javafx.stage.Stage;


public class Launcher extends Application {


    private static int sampleRate = 44100;
    private static int sampleSizeInBits = 8;
    private static int channels = 1;
    private static boolean signed = true;
    private static boolean bigEndian = false;

    public static int time = 0;

    public static boolean firstTime = true;

    public static double[] frequencies = new double[22050];
    public static double[] outImag = new double[22050];
    public static double[] outReal = new double[22050];


    public static void main(String[] args) {
//
//        Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
//
//        int temp = 0;
//        for(Mixer.Info mixer : mixerInfo) {
//            for (Line.Info in : AudioSystem.getMixer(mixer).getSourceLineInfo()) {
//                System.out.println("MIXER " + temp++ + ":: " + mixer.getDescription() +
//                        "\nMIXER_NAME:: " + mixer.getName() +
//                        "\nMIXER_VENDDOR:: " + mixer.getVendor() +
//                        "\nMIXER_VERSION:: " + in + "\n-----------------------------");
//            }
//        }
//
//
//        Mixer mixer = AudioSystem.getMixer(mixerInfo[6]);
//
//        for(Line.Info in : mixer.getSourceLineInfo()) {
//            try {
//                mixer.getLine(in).open();
//                System.out.println("MADE IT");
//            } catch (LineUnavailableException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//
//        System.out.println("OPENED LINES FOR:: " + mixer.getMixerInfo());
//
//        AudioFormat audioFormat = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
//
//        TargetDataLine targetLine;
//
//        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);
//
//        if(!AudioSystem.isLineSupported(info)) {
//            System.exit(0);
//        }
//
//        try {
//            targetLine = (TargetDataLine) AudioSystem.getLine(info);
//            targetLine.open(audioFormat);
//            targetLine.start();
//
//            int bufferSize = (int)audioFormat.getSampleRate() * audioFormat.getFrameSize();
//            int bufferSize = 256;
//            byte buffer[] = new byte[bufferSize];
//
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            int loops = 0;
//
//            while(true) {
//                int count = targetLine.read(buffer, 0, buffer.length);
//                if(count > 0) {
//                    for(Byte sample : buffer) {
//                        if(sample > 100) {
//                            System.out.println("one" + sample);
//                        }
//                    }
//                    dft(buffer, outReal, outImag);
//                    redraw(panel);
//                }
//
//
//
//                    out.write(buffer, 0, count);
//                System.out.println("LOOP " + loops++);
//            }
//            }
//
//            try {
//                out.close();
//            } catch(IOException e) {
//                e.printStackTrace();
//            }
//        } catch(LineUnavailableException e) {
//            System.out.println("error::\n" + e);
//        }
//
//    }
//
//    private static void redraw(DrawPanel oldPanel) {
//        application.remove(oldPanel);
//        DrawPanel newPanel = new DrawPanel();
//        application.add(newPanel);
//        panel = newPanel;
//        application.setVisible(true);

        launch(args);
//    System.out.println("BLAH");


    }

    @Override
    public void init() {TheWizard.getInstance().init();}

    @Override
    public void start(Stage primaryStage) {TheWizard.getInstance().start(primaryStage);}

    @Override
    public void stop() {TheWizard.getInstance().stop();}
}


