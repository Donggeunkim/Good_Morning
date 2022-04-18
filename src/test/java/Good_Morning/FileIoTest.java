package Good_Morning;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

public class FileIoTest {
    FileIo file_io;

    @BeforeEach
    void SetUp() {
        file_io = mock(FileIo.class);
    }

    @Test
    void CheckFileName_test() {
        assertEquals(false, file_io.CheckFileName("input.txy"));
        assertEquals(true, file_io.CheckFileName("input.txt"));
    }

    @Test
    void ReadInputFile_test(){
        String filePath = null;
        assertThrows(NullPointerException.class, () -> file_io.ReadInputFile(filePath));

        String filePath2 = "NoneFile.txt";
        assertThrows(IOException.class, () -> file_io.ReadInputFile(filePath2));
    }

    @Test
    void WritePrint2File(){
        String filePath = null;
        ArrayList<String> printList = new ArrayList<String>(
                Arrays.asList("ADD, , , ,04766290,BAE UDQJNXD,CL1,010-7899-1662,19770102,ADV",
                              "ADD, , , ,14387681,CHOI HMDEJXV,CL3,010-0424-2511,19870508,ADV",
                              "ADD, , , ,18050301,KYUMOK KIM,CL2,010-9777-6055,19980906,PRO"));

        assertThrows(NullPointerException.class, () -> file_io.WritePrint2File(filePath, printList));
    }
}
