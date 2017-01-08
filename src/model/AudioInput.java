package model;

import javax.sound.sampled.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class AudioInput {

	private static int sampleRate = 44100;
	private static int sampleSizeInBits = 8;
	private static int channels = 1;
	private static boolean signed = true;
	private static boolean bigEndian = false;
	private static TargetDataLine targetDataLine = null;

	public AudioInput() {
		try {
			preparePorts();
		} catch (LineUnavailableException e) {
			System.out.println("problem preparing port::\n" + e);
		}
	}

	public static void preparePorts() throws LineUnavailableException {
		Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
        int temp = 0;
        for(Mixer.Info mixer : mixerInfo) {
//            for (Line.Info in : AudioSystem.getMixer(mixer).getSourceLineInfo()) {
                System.out.println("MIXER " + temp++ + ":: " + mixer.getDescription() +
                        "\nMIXER_NAME:: " + mixer.getName() +
                        "\nMIXER_VENDDOR:: " + mixer.getVendor() +
                        "\nMIXER_VERSION:: " + mixer.getVersion() + "\n-----------------------------");
//            }
        }
        Mixer mixer = AudioSystem.getMixer(mixerInfo[6]);

        for(Line.Info in : mixer.getSourceLineInfo()) {
                mixer.getLine(in).open();
                System.out.println("MADE IT");
        }

        System.out.println("OPENED LINES FOR:: " + mixer.getMixerInfo());

        AudioFormat audioFormat = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);

        TargetDataLine targetLine;

        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

        if(!AudioSystem.isLineSupported(info)) {
            System.exit(0);
        }

//        try {
            targetLine = (TargetDataLine) AudioSystem.getLine(info);
            targetLine.open(audioFormat);
            targetLine.start();

            targetDataLine = targetLine;
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
	}

	public static Map<Mixer.Info, Integer> getAvailableDevicesForMenuSelection() {
		Map<Mixer.Info, Integer> toReturn = new HashMap<>();
		int index = 0;
		for(Mixer.Info info : AudioSystem.getMixerInfo()) {
			if(isValid(info.getName())) {
				toReturn.put(info, index);
			}
		}
		return toReturn;
	}

	private static boolean isValid(String name) {
		return name.toLowerCase().contains("port") && !name.toLowerCase().contains("output");
	}

}
