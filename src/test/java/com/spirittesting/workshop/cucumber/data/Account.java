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

    // | Kontonummer | Waehrung | Betrag   |
    // | 21020002    | EUR      | 0.0      |

    private String accountNumber;
    private String currency;
    private String amount;

}
