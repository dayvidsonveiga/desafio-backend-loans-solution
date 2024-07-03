package br.com.loans.controller.dto;

import br.com.loans.controller.domain.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
}
