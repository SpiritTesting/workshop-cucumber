package com.spirittesting.workshop.cucumber.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    // | Name      | Kontonummer | Waehrung | Betrag |
    // | Girokonto | 100000001   | EUR      | 500,00 |

    private String name;
    private String accountNumber;
    private String currency;
    private String amount;

}
