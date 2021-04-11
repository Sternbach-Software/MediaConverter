import java.io.File;

public class Main {
    public static void main(String[] args) throws EncoderException {
        File source = new File("C:\\Users\\Shmuel\\Downloads\\Rabbi Scher Shiurim\\Yaakov- Man of Truth.wma");
        File target = new File("target1.mp3");
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(64000);
        audio.setChannels(2);
        audio.setSamplingRate(44100);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");
        attrs.setAudioAttributes(audio);
        Mine mine = new Mine();
        Encoder encoder = new Encoder();
        encoder.encode(source, target, attrs, mine);
    }
    public static class Mine implements EncoderProgressListener {
        public void sourceInfo(MultimediaInfo info) {
            System.out.println(info);
        }
        public void progress(int permil){
            System.out.println("Progress: "+((permil)/10.0)+"%");
        }
        public void message(String message){
            System.out.println(message);
        }

    }
}
