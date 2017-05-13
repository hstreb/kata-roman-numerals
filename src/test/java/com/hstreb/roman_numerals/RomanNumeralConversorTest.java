package com.hstreb.roman_numerals;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RomanNumeralConversorTest {

    private RomanNumeralConversor conversor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        this.conversor = new RomanNumeralConversor();
    }

    @Test
    public void testConvert_GivenZero_ThenReturnNotsupported() throws Exception {
        try {
            conversor.convert(0);
            expectedException.expect(NotSupportedRomanNumeralException.class);
        } catch (NotSupportedRomanNumeralException e) {
            assertThat(e.getMessage(), is("0 is not supported by roman numerals!"));
        }
    }

    @Test
    public void testConvert_GivenNegativeNumber_ThenReturnNotsupported() throws Exception {
        try {
            conversor.convert(-1);
            expectedException.expect(NotSupportedRomanNumeralException.class);
        } catch (NotSupportedRomanNumeralException e) {
            assertThat(e.getMessage(), is("-1 is not supported by roman numerals!"));
        }
    }

    @Test
    public void testConvert_GivenOne_ThenReturnI() throws Exception {
        assertThat(conversor.convert(1), is("I"));
    }

    @Test
    public void testConvert_GivenTen_ThenReturnX() throws Exception {
        assertThat(conversor.convert(10), is("X"));
    }

    @Test
    public void testConvert_GivenAHundredAndTwelve_ThenReturnCXII() throws Exception {
        assertThat(conversor.convert(112), is("CXII"));
    }

    @Test
    public void testConvert_GivenTwoThousandAndSeventeen_ThenReturnMMXVII() throws Exception {
        assertThat(conversor.convert(2017), is("MMXVII"));
    }
}