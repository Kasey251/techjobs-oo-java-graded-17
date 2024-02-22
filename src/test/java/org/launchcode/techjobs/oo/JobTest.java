package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
public class JobTest {
    //TODO: Create your unit tests here
    private Job job1;
    private Job job2;
    private Job job3;
    @Before
    public void setUp() {
        job1 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId(){
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String jobTest = job3.toString();
        assertTrue(jobTest.startsWith("\n"));
        assertTrue(jobTest.endsWith("\n"));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        assertTrue(job3.toString().contains("ID: "));
        assertTrue(job3.toString().contains("Name: Product tester"));
        assertTrue(job3.toString().contains("Employer: ACME"));
        assertTrue(job3.toString().contains("Location: Desert"));
        assertTrue(job3.toString().contains("Position Type: Quality control"));
        assertTrue(job3.toString().contains("Core Competency: Persistence"));
    }
    @Test
    public void testToStringHandlesEmptyField() {
        String jobTest = job1.toString();
        assertTrue(jobTest.contains("ID: "));
        assertTrue(jobTest.contains("Name: Data not available"));
        assertTrue(jobTest.contains("Employer: Data not available"));
        assertTrue(jobTest.contains("Location: Data not available"));
        assertTrue(jobTest.contains("Position Type: Data not available"));
        assertTrue(jobTest.contains("Core Competency: Data not available"));
    }
}
