package br.com.loans.controller.domain;

import br.com.loans.controller.factory.CustomerFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CustomerTest {

    @Nested
    class isIncomeEqualOrLowerThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.build(5000.00);

            assertTrue(customer.isIncomeEqualOrLowerThan(5000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsLowerThanValue() {
            var customer = CustomerFactory.build(5000.00);

            assertTrue(customer.isIncomeEqualOrLowerThan(9000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsGreaterThanValue() {
            var customer = CustomerFactory.build(5000.00);

            assertFalse(customer.isIncomeEqualOrLowerThan(3000.00));
        }
    }

    @Nested
    class isIncomeEqualOrGreaterThan {

        @Test
        void shouldBeTrueWhenIncomeIsEqual() {
            var customer = CustomerFactory.build(5000.00);

            assertTrue(customer.isIncomeEqualOrGreaterThan(5000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsGreaterThanValue() {
            var customer = CustomerFactory.build(5000.00);

            assertTrue(customer.isIncomeEqualOrGreaterThan(3000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsLowerThanValue() {
            var customer = CustomerFactory.build(5000.00);

            assertFalse(customer.isIncomeEqualOrGreaterThan(8000.00));
        }
    }

    @Nested
    class isIncomeBetween {

        @Test
        void shouldBeTrueWhenIncomeIsBetween() {
            var customer = CustomerFactory.build(5000.00);

            assertTrue(customer.isIncomeBetween(3000.00, 8000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMin() {
            var customer = CustomerFactory.build(3000.00);

            assertTrue(customer.isIncomeBetween(3000.00, 8000.00));
        }

        @Test
        void shouldBeTrueWhenIncomeIsEqualToMax() {
            var customer = CustomerFactory.build(8000.00);

            assertTrue(customer.isIncomeBetween(3000.00, 8000.00));
        }

        @Test
        void shouldBeFalseWhenIncomeIsNotBetween() {
            var customer = CustomerFactory.build(5000.00);

            assertFalse(customer.isIncomeBetween(3000.00, 4000.00));
        }
    }

    @Nested
    class isAgeLowerThan {

        @Test
        void shouldBeTrueWhenAgeIsLowerThan() {
            var customer = CustomerFactory.build(25);

            assertTrue(customer.isAgeLowerThan(30));
        }

        @Test
        void shouldBeFalseWhenAgeIsNotLowerThan() {
            var customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(22));
        }

        @Test
        void shouldBeFalseWhenAgeIsEqualToValue() {
            var customer = CustomerFactory.build(25);

            assertFalse(customer.isAgeLowerThan(25));
        }
    }

    @Nested
    class isFromLocation {
        @Test
        void shouldBeTrueWhenLocationIsTheSame() {
            var customer = CustomerFactory.build("SP");

            assertTrue(customer.isFromLocation("SP"));
        }

        @Test
        void shouldBeFalseWhenLocationIsNotTheSame() {
            var customer = CustomerFactory.build("RJ");

            assertFalse(customer.isFromLocation("SP"));
        }
    }
}