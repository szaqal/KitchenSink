package com.dialoghealth.namedloganalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ParseQueryTest {

  @ParameterizedTest
  @CsvSource(delimiter = '$', value = {
      "22-Apr-2026 12:02:18.280 queries: info: client @0x7f852401df78 192.168.18.24#55522 (a.root-servers.net): query: a.root-servers.net IN A + (192.168.18.36)$ ParsedQuery[timeStamp=22-Apr-2026, client=192.168.18.24, query=a.root-servers.net]",
      "22-Apr-2026 12:15:15.365 queries: info: client @0x7f8535d78718 192.168.18.7#35125 (connectivity-check.ubuntu.com): query: connectivity-check.ubuntu.com IN AAAA +E(0) (192.168.18.36)$ ParsedQuery[timeStamp=22-Apr-2026, client=192.168.18.7, query=connectivity-check.ubuntu.com]"
  })
  public void test(String input, String expected) {
    ParsedQuery parse = FileReadJob.parse(input);
    Assertions.assertNotNull(parse);
    Assertions.assertEquals(expected, parse.toString());

  }
}
