require "../file_helper.rb"

class Day03Part1
    
    attr_reader :readings

    def initialize(input)
        @readings = FileHelper.parse(input)
    end

    def part01
      gamma_rate, epsilon_rate = calculate_gamma_and_epsilon_rates(readings)
      gamma_rate * epsilon_rate
    end

    def calculate_gamma_and_epsilon_rates(readings_list)
      most_common_bits = 
        readings_list
          .map {|diagnostic_line|  diagnostic_line.chars.map(&:to_i) }
          .transpose
          .map{|transposed| transposed.group_by(&:itself) }
          .map{|columned| most_used_digit(columned) }
          .map(&:first)

      least_common_bits = most_common_bits.join.chars.map{|bit| flip_bit(bit) }

      [most_common_bits.join.to_i(2), least_common_bits.join.to_i(2)]
    end

    def flip_bit(bit)
      bit == '1' ? '0' : '1'
    end

    def most_used_digit(values)
      values.max_by{|key, value| value.count } 
    end

end

p Day03Part1.new("./day-03-input.txt").part01