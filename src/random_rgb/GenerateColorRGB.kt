package random_rgb

import java.util.Random
object GenerateColorRGB {
    fun generateColor(r:Random):String {

        val red = r.nextInt(255)
        val blue = r.nextInt(255)
        val green = r.nextInt(255)

        return "#" + convertToHex(red) + convertToHex(blue) + convertToHex(green)
    }

    fun convertToHex(number: Int): String {
        // TODO Write own function
        val hexString = Integer.toHexString(number)

        if (hexString.length == 1) {
            return "0" + hexString
        }

        return hexString
    }
}