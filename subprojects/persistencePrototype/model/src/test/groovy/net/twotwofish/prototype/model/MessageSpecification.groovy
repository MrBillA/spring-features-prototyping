package net.twotwofish.prototype.model

import spock.lang.Specification

/**
 * MessageSpecification Description.
 *
 * @author Bill Andrews
 */
class MessageSpecification extends Specification
{
	def "Check message id accessors"() {
		setup: 'Create Message instance.'
		Message message = new Message()

		expect: 'Invoke message id accessors'
			message.setId(id)
			expectedId == message.id

		where:
			expectedId	| id
			null		| null
			3			| 3L
			-1			| -1L
	}

	def "Check message text accessors"() {
		setup: 'Create Message instance.'
		Message message = new Message()

		expect: 'Invoke message text accessors'
			message.setText(text)
			expectedText == message.text

		where:
		expectedText   | text
			null           | null
			'hello'        | 'hello'
			'hello2'       | 'hello2'
	}
}
