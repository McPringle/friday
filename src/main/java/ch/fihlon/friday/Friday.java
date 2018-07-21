/*
 * Friday – Create statistics about Fridays
 * Copyright (C) 2018 Marcus Fihlon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package ch.fihlon.friday;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.time.DayOfWeek.FRIDAY;
import static java.time.temporal.TemporalAdjusters.next;

public class Friday {

    public static void main(final String... args) {
        var startDate = LocalDate.of(1, 1, 1).with(next(FRIDAY));
        var endDate = LocalDate.of(3000, 1, 1);
        var result = startDate.datesUntil(endDate, Period.ofWeeks(1))
                .map(LocalDate::getDayOfMonth)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }

}
