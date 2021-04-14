package test.vmware.tb.io.tasks;

import main.vmware.tb.io.tasks.FileFinder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FileFinderTest {

    private static final String FILE_ONE_NAME = "one.txt";
    private static final String FILE_TWO_NAME = "two.exe";
    private static final String FILE_THREE_NAME = "doc.pdf";
    private FileFinder target;
    private static final String TEST_ROOT_DIR_NAME = "io" + File.separator;

    private static final String DIR_1 = "1" + File.separator;
    private static final String DIR_2 = "2" + File.separator;
    private static final String DIR_3 = "3" + File.separator;
    private static final String DIR_4 = "4" + File.separator;

    @Rule public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setup() {
        target = new FileFinder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListFilesByDirWithNull() {
        target.listFilesByDir(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListFilesByDirWithBlank() {
        target.listFilesByDir(" ");
    }

    /*
     * io/
     *
     * */
    @Test
    public void testListFilesByDirWithEmptyDir() throws IOException {
        File dir = buildTestFolders();

        List<String> findFiles = target.listFilesByDir(getRootDirPath(dir));

        assertNotNull(findFiles);
        assertTrue(findFiles.isEmpty());
    }

    /*
     * io/
     *   -one.txt
     *
     * */
    @Test
    public void testListFilesByDirWithOneFile() throws IOException {
        File dir = buildTestFolders();
        File file = folder.newFile(TEST_ROOT_DIR_NAME + FILE_ONE_NAME);

        List<String> findFiles = target.listFilesByDir(getRootDirPath(dir));

        assertNotNull(findFiles);
        assertEquals(1, findFiles.size());
        assertTrue(findFiles.contains(file.getAbsolutePath()));
    }

    /*
     * io/
     *   -one.txt
     *   -two.exe
     *
     * */
    @Test
    public void testListFilesByDirWithTwoFiles() throws IOException {
        File dir = buildTestFolders();
        File file1 = folder.newFile(TEST_ROOT_DIR_NAME + File.separator + FILE_ONE_NAME);
        File file2 = folder.newFile(TEST_ROOT_DIR_NAME + File.separator + FILE_TWO_NAME);

        List<String> findFiles = target.listFilesByDir(getRootDirPath(dir));

        assertNotNull(findFiles);
        assertEquals(2, findFiles.size());
        assertTrue(findFiles.contains(file1.getAbsolutePath()));
        assertTrue(findFiles.contains(file2.getAbsolutePath()));
    }

    /*
     * io/
     *   -1/
     *     -2/
     *   -one.txt
     *
     * */
    @Test
    public void testListFilesByDirWithOneFileAndTwoFolders() throws IOException {
        File dir = buildTestFolders(DIR_1, DIR_2);
        File file = folder.newFile(TEST_ROOT_DIR_NAME + FILE_ONE_NAME);

        List<String> findFiles = target.listFilesByDir(getRootDirPath(dir));

        assertNotNull(findFiles);
        assertFalse(findFiles.isEmpty());
        assertEquals(1, findFiles.size());
        assertTrue(findFiles.contains(file.getAbsolutePath()));
    }

    /*
     * io/
     *   -1/
     *     -one.txt
     *     -2/
     *       -two.exe
     *       -doc.pdf
     *       -3/
     *         -one.txt
     *         -4/
     *
     * */
    @Test
    public void testListFilesByDirWithManyFilesFolders() throws IOException {
        File dir = buildTestFolders(DIR_1, DIR_2, DIR_3, DIR_4);
        File file1 = folder.newFile(TEST_ROOT_DIR_NAME + DIR_1 + FILE_ONE_NAME);
        File file2 = folder.newFile(TEST_ROOT_DIR_NAME + DIR_1 + DIR_2 + FILE_TWO_NAME);
        File file3 = folder.newFile(TEST_ROOT_DIR_NAME + DIR_1 + DIR_2 + FILE_THREE_NAME);
        File file4 = folder.newFile(TEST_ROOT_DIR_NAME + DIR_1 + DIR_2 + DIR_3 + FILE_ONE_NAME);

        List<String> findFiles = target.listFilesByDir(getRootDirPath(dir));

        assertNotNull(findFiles);
        assertEquals(4, findFiles.size());
        assertTrue(findFiles.contains(file1.getAbsolutePath()));
        assertTrue(findFiles.contains(file2.getAbsolutePath()));
        assertTrue(findFiles.contains(file3.getAbsolutePath()));
        assertTrue(findFiles.contains(file4.getAbsolutePath()));
    }

    private File buildTestFolders(String... folders) throws IOException {
        String[] finalDirs = new String[folders.length + 1];
        finalDirs[0] = TEST_ROOT_DIR_NAME;
        System.arraycopy(folders, 0, finalDirs, 1, folders.length);
        return folder.newFolder(finalDirs);
    }

    private String getRootDirPath(File file) {
        return file.getAbsolutePath().split("io")[0];
    }
}
