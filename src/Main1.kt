import java.io.File

object Main1 {
    @Throws(EncoderException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val source = File("C:\\Users\\Shmuel\\Downloads\\Seudas Preidah FINAL with end speech Version_Trim_Trim.mp4")
        val target = File("Seudas Preidah FINAL with end speech Version_Trim_Trim1.mp3")
        val audio = AudioAttributes()
        val attrs = EncodingAttributes()
        val mine = Mine()
        val encoder = Encoder()
        audio.apply {
            codec = "libmp3lame"
            bitRate = 178000
            channels = 2
            samplingRate = 48000
        }
        attrs.apply {
            format = "mp3"
            audioAttributes = audio
        }
        encoder.encode(source, target, attrs, mine)
    }
}

class Mine : EncoderProgressListener {
    override fun sourceInfo(i: MultimediaInfo) = println(i)
    override fun progress(reallyLongVari: Int) = println("Progress: " + reallyLongVari / 10.0 + "%")
    override fun message(evenLongerVa: String) = println(evenLongerVa)
}