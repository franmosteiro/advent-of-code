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
    bingo_making_number = nil
    board_with_bingo = nil
    bingo_card.each{|current_number|
      matrix_of_boards.map { |bingo_board| bingo_board.check_number(current_number) }
      bingo_making_number = current_number
      board_with_bingo = matrix_of_boards.map(&:bingo?).find_index(true)
      break if board_with_bingo
    }
    [bingo_making_number, board_with_bingo]
  end

  def print_game_result(matrix_of_boards, board_with_bingo, bingo_making_number)
    aggregate_of_unchecked_numbers_in_board = matrix_of_boards[board_with_bingo].aggregate_of_unchecked_numbers_in_board
    puts "Score in wining board = #{aggregate_of_unchecked_numbers_in_board * bingo_making_number}."
  end

  def part1()
    boards_build_as_numbers = formated_boards()
    matrix_of_boards = build_matrix(boards_build_as_numbers)
    bingo_making_number, board_with_bingo = play_game(bingo_card, matrix_of_boards)
    print_game_result(matrix_of_boards, board_with_bingo, bingo_making_number)   
  end
end

class BingoBoard
  attr_reader :rows, :columns

  def initialize(rows)
    @rows = rows
    @columns = rows.transpose
  end

  def check_number(number)
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

BingoGame.new("day-04-input.txt").part1
