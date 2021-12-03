require "../file_helper.rb"

class Day03Part1
    
    attr_reader :readings

    def initialize(input)
        @readings = FileHelper.parse(input)
    end

    def part01
      gamma_rate = calculate_gamma_rate(readings)
      epsilon_rate = calculate_epsilon_rate(gamma_rate)
      
      gamma_rate.join.to_i(2) * epsilon_rate.join.to_i(2)
    end

    def calculate_gamma_rate(readings_list)
      readings_list
        .map {|diagnostic_line|  diagnostic_line.chars.map(&:to_i) }
        .transpose
        .map{|transposed| transposed.group_by(&:itself) }
        .map{|columned| most_used_digit(columned) }
        .map(&:first)
    end

    def calculate_epsilon_rate(gamma_rate)
      gamma_rate
        .join
        .chars
        .map{|bit| flip_bit(bit) }
    end

    def flip_bit(bit)
      bit == '1' ? '0' : '1'
    end

    def most_used_digit(values)
      values.max_by{|key, value| value.count } 
    end

end

p Day03Part1.new("./day-03-input.txt").part01