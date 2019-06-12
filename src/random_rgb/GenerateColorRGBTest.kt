package random_rgb

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Before
import java.util.Random
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue

class GenerateColorRGBTest {
    private lateinit var rgb: String
    private lateinit var rgb2: String

    @Before
    fun setUp() {
        rgb = GenerateColorRGB.generateColor(Random())
        rgb2 = GenerateColorRGB.generateColor(Random())
    }

    @Test
    fun hasHashOnStart() {
        assertEquals('#', rgb.first())
    }

    @Test
    fun hasSevenChars() {
        assertEquals(7, rgb.length)
    }


    @Test
    fun isRandomColor() {
        assertNotEquals(rgb, rgb2)
    }



    @Test
    fun eachTwoCharsAreInHexRange() {
        val redHexNumber = rgb.substring(1, 2)
        val greenHexNumber = rgb.substring(3, 4)
        val blueHexNumber = rgb.substring(4, 5)


        assertTrue(isHexNumber(redHexNumber))
        assertTrue(isHexNumber(greenHexNumber))
        assertTrue(isHexNumber(blueHexNumber))
    }

    @Test
    fun isHexNumberTest() {
        assertTrue(isHexNumber("0"))
        assertTrue(isHexNumber("ff"))
        assertFalse(isHexNumber("z"))
    }

    @Test
    fun isHexCharTest() {
        assertTrue(isHexChar('0'))
        assertTrue(isHexChar('9'))
        assertTrue(isHexChar('f'))
        assertTrue(isHexChar('F'))
        assertTrue(isHexChar('A'))
        assertTrue(isHexChar('B'))
        assertFalse(isHexChar('z'))
        assertFalse(isHexChar('K'))
    }

    @Test
    fun convertToHexTest() {
        assertEquals("00", GenerateColorRGB.convertToHex(0))
        assertEquals("0f", GenerateColorRGB.convertToHex(15))
        assertEquals("10", GenerateColorRGB.convertToHex(16))
    }



    private fun isHexNumber(hexNumber: String): Boolean {
        return !hexNumber.map { (isHexChar(it)) }.contains(false)
    }

    private fun isHexChar(it: Char) = (it.toInt() in 65..70 || it.toInt() in 97..102 || it.toInt() in 48..57)


}