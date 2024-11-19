package com.github.hvalmer.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest {

	SimpleMath math;
	
	/*antes de executar qqr teste de integração, executa o @BeforeAll,
	 * onde crio um banco, dou uma carga no banco
	 * */
	@BeforeAll
	static void setup() {
		System.out.println("Running @BeforeAll method!");
	}
	
	/*depois de executar qqr teste de integração, executa o @AfterAll,
	 * desfazendo tudo que foi feito
	 * */
	@AfterAll
	static void cleanup() {
		System.out.println("Running @AfterAll method!");
	}
	
	//executa antes de cada teste
	@BeforeEach
	void beforeEachMethod() {
		math = new SimpleMath();
		System.out.println("Running @BeforeEach method!");
	}
	
	//executa depois de cada teste
	@AfterEach
	void afterEachMethod() {
		System.out.println("Running @AfterEach method!");
	}
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	@Test
	@DisplayName("Test 6.2 + 2 = 8.2")
	void testSum() {
		
		System.out.println("Test 6.2 + 2 = 8.2");
		
		//BDD é uma boa maneira de organizar os códigos dos testes
		//AAA Arrange, Act e Assert
		//Given | Arrange
		//parametrizando a resposta 
		
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		double expected = 8.2D;
		
		//When | Act
		Double actual = math.sum(firstNumber, secondNumber);
		
		//Then | Assert
		//assertions
		//() ->[lambda function] é executada apenas na falha, ñ no sucesso, otimizando a performance
		assertEquals(expected, actual, 
				() -> firstNumber + " + " + secondNumber
				+ " did not produce " + expected + " ! ");
	}
	
	@Test
	@DisplayName("Test 6.2 - 2 = 4.2")
	void testSubtraction() {
		
		System.out.println("Test 6.2 - 2 = 4.2");
		
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.subtraction(firstNumber, secondNumber);
		double expected = 4.2D;
		
		assertEquals(expected, actual, 
				() -> firstNumber + "-" + secondNumber +
				" did not produce " + expected + " ! ");
	}
	
	@Test
	@DisplayName("Test 6.2 * 2 = 12.4")
	void testMultiplication() {
		
		System.out.println("Test 6.2 * 2 = 12.4");
		
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.multiplication(firstNumber, secondNumber);
		double expected = 12.4D;
		
		assertEquals(expected, actual, 
				() -> firstNumber + " * " + secondNumber
				+ " did not produce " + expected + " ! ");
	}
	
	@Test
	@DisplayName("Test 6.2 / 2 = 3.1")
	void testDivision() {
		
		System.out.println("Test 6.2 / 2 = 3.1");
			
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		Double actual = math.division(firstNumber, secondNumber);
		double expected = 3.1D;
		
		assertEquals(expected, actual, 
				() -> firstNumber + " / " + secondNumber
				+ " did not produce " + expected + " ! ");
	}
	
	@Test
	@DisplayName("Test (6.2 + 2)/2 = 4.1")
	void testMean() {
		
		System.out.println("Test (6.2 + 2)/2 = 4.1");
		
		
		//parametrizando a resposta 
		double firstNumber = 6.2D;
		double secondNumber = 2D;
		
		Double actual = math.mean(firstNumber, secondNumber);
		double expected = 4.1D;
		
		//assertions
		//() ->[lambda function] é executada apenas na falha, ñ no sucesso, otimizando a performance
		assertEquals(expected, actual, 
				() -> "(" + firstNumber + " + " + secondNumber + ")/2"
				+ " did not produce " + expected + " ! ");
	}
	
	// test[System Under Test]_[Condition or State Change]_[Expected Result]
	// @Disabled("TODO: We need still work on it!")
	@DisplayName("Test Division by Zero")
	@Test
	void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmetic() {

		// parametrizando a resposta
		//given
		double firstNumber = 6.2D;
		double secondNumber = 0D;
		
		//lançando a mesma mensagem da exceção
		var expectedMessage = "Impossible division by Zero!";

		// assert de exceção
		/**/
		ArithmeticException actual = assertThrows(ArithmeticException.class, () -> {
			//when & then
			math.division(firstNumber, secondNumber);
		}, ()-> "Division by Zero should throw an ArithmeticException!");
		
		/*diferentes mensagens se apresentam, inclusive o lambda function()->
		 * que é usada para executar o trecho de código, APENAS quando
		 * acontecer o erro, ganhando performance*/
		assertEquals(expectedMessage , actual.getMessage(), 
				()->"Unexpected exception message!");
	}

	@Test
	@DisplayName("Test Square Root of 81 = 9")
	void testSquareRoot() {
		
		System.out.println("Test Square Root of 81 = 9");
			
		//parametrizando a resposta 
		double number = 81D;
		double expected = 9D;
		
		Double actual = math.squareRoot(number);
		
		//assertions
		//() ->[lambda function] é executada apenas na falha, ñ no sucesso, otimizando a performance
		assertEquals(expected, actual, 
				() -> "Square Root of " + number + 
				" did not produce " + expected + " ! ");
	}
	
	//test[System Under Test]_[Condition or State Change]_[Expected Result]
	@DisplayName("Display Name")
	@Test
	void testABCD_When_XYZ_Should() {
		
		System.out.println("Test BDD");
		
		//Given / Arrange
		//When / Act
		//Thein / Assert
	}
	
}
