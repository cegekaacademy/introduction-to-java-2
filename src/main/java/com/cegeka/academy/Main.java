package com.cegeka.academy;

import com.cegeka.academy.exceptions.ListException;
import com.cegeka.academy.service.Duplicates;
import com.cegeka.academy.service.Sum;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String [ ] args) throws ListException
    {
        Sum test = new Sum();

        List<Integer> numere = new ArrayList<>();



        System.out.print(test.calculate(numere));
    }
}
