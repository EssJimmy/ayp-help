template <typename T>
class Comparable{
public:
    virtual bool operator < (T const& other) const = 0;
    virtual bool operator > (T const& other) const = 0;
    virtual bool operator == (T const& other) const =0;
    virtual bool operator != (T const& other) const {
        return !((*this) == other);
    }
};