package es.marcmauri.photobook.features.photoviewer.model

import es.marcmauri.photobook.features.photoviewer.repository.UnsplashRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import java.util.*

class PhotoViewerGridModelTest {

    private lateinit var model: PhotoViewerGridModel
    private lateinit var mockedRepository: UnsplashRepository

    @Before
    fun setUp() {
        mockedRepository = mock(UnsplashRepository::class.java)
        model = PhotoViewerGridModel(mockedRepository)
    }

    @Test
    fun testDateConversionOnLastDayOfTheYear() {
        val date = model.stringToDate("2021-12-31T23:59:59-04:00")
        assertNotNull(date)
        val calendar = Calendar.getInstance()
        calendar.time = date
        assertEquals(31, calendar.get(Calendar.DAY_OF_MONTH))
        assertEquals(11, calendar.get(Calendar.MONTH)) // Gregorian calendar
        assertEquals(2021, calendar.get(Calendar.YEAR))
        assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY))
        assertEquals(59, calendar.get(Calendar.MINUTE))
        assertEquals(59, calendar.get(Calendar.SECOND))
    }

    @Test
    fun testDateConversionOnFirstDayOfTheYear() {
        val date = model.stringToDate("2022-01-01T00:00:00-04:00")
        assertNotNull(date)
        val calendar = Calendar.getInstance()
        calendar.time = date
        assertEquals(2022, calendar.get(Calendar.YEAR))
        assertEquals(0, calendar.get(Calendar.MONTH)) // Gregorian calendar
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH))
        assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY))
        assertEquals(0, calendar.get(Calendar.MINUTE))
        assertEquals(0, calendar.get(Calendar.SECOND))
    }

    @Test
    fun testDateConversionOnNullDate() {
        val date = model.stringToDate(null)
        assertNotNull(date)
        val currentCalendar = Calendar.getInstance()
        currentCalendar.time = Date()
        val testCalendar = Calendar.getInstance()
        testCalendar.time = date
        assertEquals(currentCalendar.get(Calendar.YEAR), testCalendar.get(Calendar.YEAR))
        assertEquals(currentCalendar.get(Calendar.MONTH), testCalendar.get(Calendar.MONTH))
        assertEquals(
            currentCalendar.get(Calendar.DAY_OF_MONTH),
            testCalendar.get(Calendar.DAY_OF_MONTH)
        )
    }
}