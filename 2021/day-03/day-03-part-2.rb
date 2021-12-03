require "../file_helper.rb"
require "pry"

class Day03Part2
    
    attr_reader :readings

    def initialize(input)
        @readings = FileHelper.parse(input)
    end

    def part02

      oxygen_generator_rating = readings.dup
      co2_scrubber_rating = readings.dup

      (0..readings.size).to_a.each {|i|
        most_common, _ = base_common_pattern(oxygen_generator_rating)
        oxygen_generator_rating.reject!{|lines| most_common[i] != lines[i]}
      }

      (0..readings.size).to_a.each {|i|
        _, least_common = base_common_pattern(co2_scrubber_rating)
        co2_scrubber_rating.reject!{|lines| least_common[i] != lines[i]}
        break if co2_scrubber_rating.size == 1
      }

      oxygen_generator_rating.first.to_i(2) * co2_scrubber_rating.first.to_i(2)
    end

    def base_common_pattern(readings_list)
      most_common_bits = 
        readings_list
          .map {|diagnostic_line|  diagnostic_line.chars.map(&:to_i) }
          .transpose
          .map{|transposed| transposed.group_by(&:itself) }
          .map{|columned| most_used_digit(columned) }
          .map(&:first)

      least_common_bits = most_common_bits.join.chars.map{|bit| flip_bit(bit) }

      [most_common_bits.join, least_common_bits.join]
    end

    def flip_bit(bit)
      bit == '1' ? '0' : '1'
    end

    def most_used_digit(values)
      values.sort_by{|k,v| iamacrafter(k)}.max_by{|key, value| 
        value.count 
      } 
    end

    # `max_by` returns the first found if draw, so we hacked it with this mighty code!
    def iamacrafter(k)
      -k.to_s.to_i
    end
end

p Day03Part2.new("./day-03-input.txt").part02