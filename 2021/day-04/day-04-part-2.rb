require "../file_helper.rb"

class BingoGame
  attr_reader :raw_bingo_game, :bingo_card, :raw_bingo_boards

  def initialize(input)
    @raw_bingo_game = FileHelper.parse(input)
    @bingo_card = raw_bingo_game.shift(1).first.split(',').map(&:chomp).map(&:to_i)
    @raw_bingo_boards = raw_bingo_game
  end

  def formated_boards
    boards_build_as_numbers = []
    board_delimiter = false

    raw_bingo_boards.each{|raw_line|
      if raw_line == ""
        board_delimiter = false
      elsif raw_line.size != 0 && board_delimiter == false
        board_delimiter = true
        boards_build_as_numbers << raw_line.split.map(&:chomp).map(&:to_i)
      else
        boards_build_as_numbers << raw_line.split.map(&:chomp).map(&:to_i)
      end
    }

    boards_build_as_numbers
  end

  def build_matrix(boards_build_as_numbers)
    matrix_of_boards = []
    total_boards = boards_build_as_numbers.size / 5
    total_boards.times { |board| matrix_of_boards << BingoBoard.new(boards_build_as_numbers.shift(5)) }
    matrix_of_boards
  end

  def play_game(bingo_card, matrix_of_boards)
    number_which_made_completed_bingo_the_last = nil
    board_completing_bingo_last = nil

    bingo_card.each do |current_bingo_card_number|
        matrix_of_boards.map { |board| board.mark_as_found(current_bingo_card_number) }
        number_which_made_completed_bingo_the_last = current_bingo_card_number
        boards_without_bingo = matrix_of_boards.map(&:bingo?).count(false)
        board_completing_bingo_last = matrix_of_boards.map(&:bingo?).find_index(false) if boards_without_bingo == 1
        break if boards_without_bingo == 0
    end

    [number_which_made_completed_bingo_the_last, board_completing_bingo_last]
  end

  def print_game_result(matrix_of_boards, board_completing_bingo_last, number_which_made_completed_bingo_the_last)
    aggregate_of_unchecked_numbers_in_board = matrix_of_boards[board_completing_bingo_last].aggregate_of_unchecked_numbers_in_board
    puts "Score in losing board = #{aggregate_of_unchecked_numbers_in_board * number_which_made_completed_bingo_the_last}."
  end

  def part2()
    boards_build_as_numbers = formated_boards()
    matrix_of_boards = build_matrix(boards_build_as_numbers)
    number_which_made_completed_bingo_the_last, board_completing_bingo_last = play_game(bingo_card, matrix_of_boards)

    aggregate_of_unchecked_numbers_in_board = matrix_of_boards[board_completing_bingo_last].aggregate_of_unchecked_numbers_in_board
    puts "Score in losing board = #{aggregate_of_unchecked_numbers_in_board * number_which_made_completed_bingo_the_last}."

  end
end

class BingoBoard
  attr_reader :rows, :columns

  def initialize(rows)
    @rows = rows
    @columns = rows.transpose
  end

  def mark_as_found(number)
    @rows = @rows.each { |row| row.reject! { |item| item == number } }
    @columns = @columns.each { |col| col.reject! { |item| item == number } }
  end

  def bingo?
    @rows.select(&:empty?).any? || @columns.select(&:empty?).any?
  end

  def aggregate_of_unchecked_numbers_in_board
    @rows.flatten.sum
  end
end

BingoGame.new("day-04-input.txt").part2
