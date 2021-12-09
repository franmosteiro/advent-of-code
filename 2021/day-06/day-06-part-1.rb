require "../file_helper.rb"

class Day06
    
    attr_reader :data

    def initialize(input)
      @data = IO.read(input).split(",").map(&:to_i)
    end

    def part1
      lanternfishes = data.map{ |days_left_for_birth| Lanternfish.new(days_left_for_birth) }
			80.times{
        lanternfishes.each {|lanterfish|
          if lanterfish.days_left_for_birth == 0
            lanternfishes << Lanternfish.new(8, true)
          end
          lanterfish.tick()
        }
      }
      lanternfishes.count
    end

end

class Lanternfish
  
  attr_accessor :days_left_for_birth, :recently_birth
  
  def initialize(state, recently_birth = false)
    @days_left_for_birth = state
    @recently_birth = recently_birth
  end

  def tick
    if recently_birth
      @recently_birth = false
    else
      if days_left_for_birth == 0
        @days_left_for_birth = 6
      else
        @days_left_for_birth = @days_left_for_birth - 1
      end
    end
  end

  private
    def recently_birth?
      recently_birth
    end

end

p Day06.new("day-06-input.txt").part1